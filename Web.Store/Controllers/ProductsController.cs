using AutoMapper;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using Web.Store.Data;
using Web.Store.Data.Entities;
using Web.Store.Models;
using Web.Store.Repositories;

namespace Web.Store.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductsController : ControllerBase
    {
        //private readonly EFAppContext _context;
        //public ProductsController(EFAppContext context)
        //{
        //    _context = context;
        //}

        private readonly IRepository<Product> _context;
        private readonly IRepository<ProductImage> _context_image;
        private readonly IMapper _mapper;
        public ProductsController(IRepository<Product> repository, IRepository<ProductImage> repository_image, IMapper mapper)
        {
            this._context = repository;
            this._context_image = repository_image;
            _mapper = mapper;
        }

        //[HttpGet("all")]
        //public async Task<IActionResult> GetAll()
        //{
        //    var list = await _context.Products.ToListAsync();
        //    return Ok(list);
        //}

        /// <summary>
        /// Get list of products
        /// </summary>
        /// <returns></returns>
        [HttpGet("all")]
        public IActionResult GetAll()
        {
            var products = _context.GetAll().ToList();
            List<ProductInfoVM> listProductModelView = _mapper.Map<List<ProductInfoVM>>(products);
            if (products.Count == 0)
            {
                return Ok(listProductModelView);//NotFound(listProductModelView);
            }

            Thread.Sleep(3000); //for check loader
            return Ok(listProductModelView);
        }

        [HttpGet("images")]
        public IActionResult GetAllImages()
        {
            //var products = _context.GetAll().ToList();
            var listProductModelView = (List<string>)_context_image.GetAll().Select(x => "/images/" + x.Name).ToList();

            if (listProductModelView.Count == 0)
            {
                return Ok(listProductModelView);//NotFound(listProductModelView);
            }

            //Thread.Sleep(3000); //for check loader
            return Ok(listProductModelView);
        }

        //[HttpGet("get/{id}")]
        //public async Task<IActionResult> GetById(int id)
        //{
        //    var list = await _context.ProductImages
        //        .Select(x=>new ProductInfoVM 
        //        {
        //            Id=x.Id,
        //            Path="/images/"+x.Name
        //        })
        //        .ToListAsync();
        //    return Ok(list);
        //}

        [HttpGet("get/{id}")]
        public IActionResult GetById(int id)
        {

            var list = _context.GetAll().Select(x => new ProductInfoVM
            {
                Id=x.Id,
                Name = x.Name,
                Price = x.Price,
                Path = "/images/" + x.Name,
            });

            
            return Ok(list);
        }
    }
}
